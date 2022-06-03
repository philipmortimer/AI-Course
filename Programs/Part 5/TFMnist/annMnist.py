import tensorflow as tf

# Loads dataset, normalising pixel values
mnist = tf.keras.datasets.mnist

(x_train, y_train), (x_test, y_test) = mnist.load_data()
x_train, x_test = x_train / 255.0, x_test / 255.0

# Creates Neural Network model to use
model = tf.keras.models.Sequential([
  tf.keras.layers.Flatten(input_shape=(28, 28)),
  tf.keras.layers.Dense(128, activation='relu'),
  tf.keras.layers.Dropout(0.2),
  tf.keras.layers.Dense(10)
])

# Gets model predictions
predictions = model(x_train[:1]).numpy()
predictions

# Applies softmax function to output
tf.nn.softmax(predictions).numpy()

# Uses categorical cross entropy for loss function
loss_fn = tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True)

# Computes loss for training data and actual output
loss_fn(y_train[:1], predictions).numpy()

# Compiles the model, using the adam optimiser
model.compile(optimizer='adam',
              loss=loss_fn,
              metrics=['accuracy'])

# Trains the model
model.fit(x_train, y_train, epochs=5)

# Evaluates model performance on appropriate dataset
model.evaluate(x_test,  y_test, verbose=2)

# Wraps model with softmax activation and can now be used for prediction
probability_model = tf.keras.Sequential([
  model,
  tf.keras.layers.Softmax()
])
probability_model(x_test[:5])