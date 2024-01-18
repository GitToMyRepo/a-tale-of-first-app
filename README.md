* Build Docker Image:
```
PS C:\idev\simple-consumer-app> docker build -t simple-consumer-app .
```
* Build and Run Docker Container:
```
PS C:\idev\simple-consumer-app> docker run -p8080:8080 --name simple-consumer-app-container --net producer-consumer-network simple-consumer-app:latest
```
