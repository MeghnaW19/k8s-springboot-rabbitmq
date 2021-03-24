
## Exercise: Deploy a Spring Boot microservices applications that produces and consumes messages using RabbitMQ on a K8s Cluster  

* In this Exercise, you will deploy a Spring Boot microservices applications producing and consuming data using RabbitMQ on K8s Cluster.  

This exercise contains the following:

	- producer-service - A SpringBoot application which produces data to RabbitMq in K8 Cluster.
	- consumer-service - A SpringBoot application which consumes data from RabbitMq in K8 Cluster.
	- k8s-manifests - Contains manifest files:
	
This exercise contains following files in k8s-manifests folder:

	- rabbitsecret.yml - To create secret
	- rabbitmq.yml - To create the StatefulSet, and two services, one to expose the management HTTP port on each node and second for StatefulSets.
	- producer.yml - To create the deployment, service of type NodePort for producer-app microservice.
	- consumer.yml - To create the deployment, service of type NodePort for consumer-app microservice.

  

Understand and perform the following steps to complete and verify the outcome:
	 

	1. Define a secret in `rabbitsecret.yml` to hold three values using the data field.
	Convert the strings to base64 by running command `echo -n '<value>' | base64` for each of the following values:
	-  `guest` for username
	-  `guest` for password
	-  `c-is-for-cookie-thats-good-enough-for-me` for erlang-cookie
	2. Run command `kubectl apply -f rabbitmqsecret.yml` to create the secret.
	3. Define StatefulSet and two services in `rabbitmq.yml following the comments given in the file.
	4. Run command `kubectl apply -f rabbitmq.yml` to create the RabbitMQ StatefulSet and services.
	5. Run command `kubectl describe service rabbitmq-management` and look up the NodePort.
	Connect to the minikube IP of one of your nodes and the NodePort in a web browser and login with username guest and password guest.
	This is the RabbitMQ management UI.
	6. Modify the properties in `application.yml` of both `producer-service` and `consumer-service` following the comments given in both the files.
	7. Push the docker images of both applications to DockerHub.
	8. Define service of type NodePort and deployment in `producer.yml' following the comments given in the file.
	9. Similarly, define service of type NodePort and deployment in `consumer.yml' following the comments given in the file.
	10. Run command `kubectl apply -f producer.yml` to create Producer Deployment and Service.
	11. Run command `kubectl logs <producer pod name>` and check if the service has started and connected to RabbitMQ.
	12. Run command `kubectl describe service <producer service name>` and look up for NopePort.
	13. To produce data in RabbitMQ, open POSTMAN and hit the POST endpoint using `http://<minikube ip>:<nodeport>/api/v1/employee`.
	14. Run command `kubectl apply -f consumer.yml` to create Consumer Deployment and Service.
	15. Run command `kubectl logs <consumer pod name>` and check if the data is consumed from RabbitMQ.
	16. You can also verify the production and consumption of data through the RabbitMQ management UI opened in Step 5.


### Instructions

- Take care of whitespace/trailing whitespace
- Do not change the provided code unless instructed
- Ensure your code compiles without any errors/warning/deprecations
- Follow best practices while coding