from sklearn.datasets import make_blobs
import pandas as pd
from yellowbrick.cluster import KElbowVisualizer
from sklearn.cluster import KMeans
import seaborn as sns
import matplotlib.pyplot as plt

# Loads dataset (which should be 4 clusters)
dataset, classes = make_blobs(n_samples=200, n_features=2, centers=4, cluster_std=0.5, random_state=0)
df = pd.DataFrame(dataset, columns=['var1', 'var2'])

# Creates K means model and performs elbow method to determine which k is best
model = KMeans()
visualizer = KElbowVisualizer(model, k=(1,12)).fit(df)
visualizer.show()

# Plots data before k-means used to categorise it
sns.scatterplot(data=df, x="var1", y="var2")
plt.show()

# Using elbow method, we have decided that k = 4 is most appropriate
# Use k means clustering on data now
kmeans = KMeans(n_clusters=4).fit(df)

# Visualises clustered data, plotting centroids too
sns.scatterplot(data=df, x="var1", y="var2", hue=kmeans.labels_)
plt.scatter(kmeans.cluster_centers_[:, 0], kmeans.cluster_centers_[:, 1],
            marker="X", c="r", s=80, label="centroids")
plt.legend()
plt.show()
