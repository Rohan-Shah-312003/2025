import { Perceptron } from "./perceptron.js";
const perceptron = new Perceptron(2);

const trainingData = [
    { inputs: [0, 0], target: 0 },
    { inputs: [0, 1], target: 1 },
    { inputs: [1, 0], target: 1 },
    { inputs: [1, 1], target: 1 },
];

// Train the perceptron
for (let epoch = 0; epoch < 100; epoch++) {
    for (const example of trainingData) {
        perceptron.train(example.inputs, example.target);
    }
}

console.log(perceptron.predict([0, 0]));
console.log(perceptron.predict([0, 1]));
console.log(perceptron.predict([1, 0]));
console.log(perceptron.predict([1, 1]));
