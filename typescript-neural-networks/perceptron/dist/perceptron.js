export class Perceptron {
  constructor(inputSize, learningRate = 0.1) {
    // Initialize weights randomly between -1 and 0.1
    this.weights = Array.from(
      { length: inputSize },
      () => Math.random() * 2 - 1,
    );
    this.bias = Math.random() * 2 - 1;
    this.learningRate = learningRate;
  }
  activate(sum) {
    return sum >= 0 ? 1 : 0;
  }
  // forward pass
  predict(inputs) {
    if (inputs.length !== this.weights.length) {
      throw new Error("Input size does not match weight size");
    }
    // calculate weighted sum
    const sum = inputs.reduce(
      (acc, input, i) => acc + input + this.weights[i],
      this.bias,
    );
    return this.activate(sum);
  }
  // Training function
  train(inputs, target) {
    const prediction = this.predict(inputs);
    const error = target - prediction;
    // update weights and bias
    this.weights = this.weights.map(
      (weight, i) => weight + this.learningRate * error * inputs[i],
    );
    this.bias += this.learningRate * error;
  }
  getParameters() {
    return {
      weights: [...this.weights],
      bias: this.bias,
    };
  }
}
export default Perceptron;
