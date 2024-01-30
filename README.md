# housing-publication

This project is a simple Housing Management Service implemented in Java. It provides functionality to retrieve housings by status. We can create, update housings.
You can use the postman_collection.json to test the service.

## Table of Contents

- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Building the Project](#building-the-project)
- [Usage](#usage)
    - [Running Locally](#running-locally)
    - [Docker](#docker)
- [Endpoints](#endpoints)
- [Tests](#tests)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17
- Apache Maven
- Docker (optional, for containerization)

### Building the Project

Clone the repository and navigate to the project directory:

### Running Locally

To run the project use maven or IDE like intellij or VSCode.

### Docker
- Build the Docker Image, in the directory containing your Dockerfile.
```bash
docker build -t housing-publication .
```
OR
- Get the Docker Image with Dockerhub.
```bash
docker pull cloudprojectantoninkylian/housing-publication:1.1.0
```
- Run the Docker Container
```bash
docker run -p 8080:8080 housing-publication:latest
```

### Kubernetes Deployment

We can deploy this service to Kubernetes using deployment.yaml with this command :
```bash
minikube start
kubectl apply -f .\deploy\deployment.yaml
kubectl apply -f .\deploy\housing-publication-service.yaml
```
