import pandas as pd
import numpy as np
import re
import json
from pathlib import Path
from typing import List, Dict, Tuple
import unicodedata

class AncientTextPreprocessor:
    def __init__(self, language: str):
        """
        Initialize preprocessor for specific ancient language
        
        Args:
            language: One of ['sanskrit', 'egyptian', 'arabic']
        """
        self.language = language.lower()
        self.special_chars = self._get_special_chars()
        
    def _get_special_chars(self) -> Dict[str, str]:
        """Return special characters mapping for the selected language"""
        chars = {
            'sanskrit': {
                # Common Sanskrit diacritics and special characters
                'ā': 'aa', 'ī': 'ii', 'ū': 'uu', 'ṃ': 'm', 'ḥ': 'h'
            },
            'egyptian': {
                # Transliteration marks for Egyptian
                'ꜣ': 'a', 'ḫ': 'kh', 'ḏ': 'dj'
            },
            'arabic': {
                # Arabic diacritics
                'ً': '', 'ٌ': '', 'ٍ': '', 'َ': '', 'ُ': '', 'ِ': ''
            }
        }
        return chars.get(self.language, {})

    def load_text(self, file_path: str) -> List[str]:
        """
        Load text from various file formats
        
        Args:
            file_path: Path to the input file
        
        Returns:
            List of text sentences/lines
        """
        path = Path(file_path)
        if path.suffix == '.txt':
            with open(file_path, 'r', encoding='utf-8') as f:
                return f.readlines()
        elif path.suffix == '.json':
            with open(file_path, 'r', encoding='utf-8') as f:
                data = json.load(f)
                return data['texts'] if isinstance(data, dict) else data
        else:
            raise ValueError(f"Unsupported file format: {path.suffix}")

    def normalize_text(self, text: str) -> str:
        """
        Normalize text by handling special characters and diacritics
        
        Args:
            text: Input text string
        
        Returns:
            Normalized text string
        """
        # Replace special characters
        for original, replacement in self.special_chars.items():
            text = text.replace(original, replacement)
        
        # Normalize Unicode characters
        text = unicodedata.normalize('NFKD', text)
        
        # Remove remaining diacritics
        text = ''.join(c for c in text if not unicodedata.combining(c))
        
        return text

    def tokenize(self, text: str) -> List[str]:
        """
        Tokenize text into words/tokens
        
        Args:
            text: Input text string
        
        Returns:
            List of tokens
        """
        # Basic tokenization - can be enhanced based on specific language rules
        tokens = re.findall(r'\b\w+\b', text.lower())
        return tokens

    def create_parallel_dataset(
        self,
        ancient_texts: List[str],
        english_texts: List[str],
        output_file: str
    ) -> None:
        """
        Create parallel dataset for translation training
        
        Args:
            ancient_texts: List of source language texts
            english_texts: List of corresponding English translations
            output_file: Path to save the processed dataset
        """
        if len(ancient_texts) != len(english_texts):
            raise ValueError("Number of source and target texts must match")
        
        dataset = []
        for src, tgt in zip(ancient_texts, english_texts):
            # Normalize and preprocess source text
            src_normalized = self.normalize_text(src.strip())
            src_tokens = self.tokenize(src_normalized)
            
            # Normalize target text
            tgt_normalized = tgt.strip()
            
            dataset.append({
                'source': ' '.join(src_tokens),
                'target': tgt_normalized,
                'source_lang': self.language,
                'target_lang': 'english'
            })
        
        # Save to JSON file
        with open(output_file, 'w', encoding='utf-8') as f:
            json.dump(dataset, f, ensure_ascii=False, indent=2)

    def process_batch(
        self,
        input_dir: str,
        output_dir: str,
        batch_size: int = 1000
    ) -> None:
        """
        Process multiple files in batches
        
        Args:
            input_dir: Directory containing input files
            output_dir: Directory to save processed files
            batch_size: Number of texts to process in each batch
        """
        input_path = Path(input_dir)
        output_path = Path(output_dir)
        output_path.mkdir(exist_ok=True)
        
        files = list(input_path.glob('*.txt')) + list(input_path.glob('*.json'))
        
        for file in files:
            texts = self.load_text(str(file))
            
            # Process in batches
            for i in range(0, len(texts), batch_size):
                batch = texts[i:i + batch_size]
                
                processed_texts = []
                for text in batch:
                    normalized = self.normalize_text(text)
                    tokens = self.tokenize(normalized)
                    processed_texts.append(' '.join(tokens))
                
                # Save batch
                batch_file = output_path / f"{file.stem}_batch_{i//batch_size}.json"
                with open(batch_file, 'w', encoding='utf-8') as f:
                    json.dump(processed_texts, f, ensure_ascii=False, indent=2)
