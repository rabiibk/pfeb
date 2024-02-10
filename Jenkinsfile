pipeline {
    agent any

    environment {
        NEXUS_URL = 'http://192.168.12.150:8081/repository/maven-releases/'
        DOCKER_REPO = 'rabii1990/backend'
        DOCKERFILE_PATH = '/home/rabii/backend/Dockerfile'
        DOCKER_IMAGE_NAME = 'rabiiback'
        DOCKER_IMAGE_TAG = 'spring'
        NEXUS_USERNAME = 'admin'
        NEXUS_PASSWORD = 'nexus'

        DOCKER_IMAGE_NAME2 = 'rabiiback2'
        DOCKER_IMAGE_TAG2 = 'spring2'

        DOCKER_COMPOSE_HOME = '/var/lib/jenkins/workspace/pfeb'
    }

    stages {
           stage('Git') {
               steps {
                   echo 'My first job pipeline angular'
                   checkout([$class: 'GitSCM', branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false, extensions: [],
                     submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/rabiibk/pfeb.git']]])
               }
           }

        stage('Compiling') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }

      //  stage('Code Coverage with Jacoco') {
      //      steps {
      //          script {
      //              sh 'mvn jacoco:prepare-agent test jacoco:report'
      //          }
      //          jacoco(execPattern: 'target/jacoco.exec')
      //      }
     //   }

        stage('JUnit et Mockito Tests') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Package JAR') {
            steps {
                script {
                    sh 'mvn package'
                }
            }
        }

        stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipTests'
            }
        }

        stage('Pull JAR & Build Docker Image') {
            steps {
              //  sh 'cp /var/lib/jenkins/.m2/repository/tn/esprit/DevOpsProject/2.1/DevOpsProject-2.1.jar /home/rabii/backend/'
                sh 'chmod 750 /var/lib/jenkins/workspace/pfeb/target/DevOpsProject-2.1.jar'
                sh 'chmod 777 /var/lib/jenkins/workspace/pfeb/Dockerfile'
                sh 'chmod 777 /var/lib/jenkins/workspace/pfeb/docker-compose.yml'
                sh "docker build -t java:back /var/lib/jenkins/workspace/pfeb "
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                sh "docker tag java:back ${DOCKER_REPO}:${DOCKER_IMAGE_TAG}"
                sh "docker login -u rabii1990 -p rabiiradar2012"
                sh "docker push ${DOCKER_REPO}:${DOCKER_IMAGE_TAG}"
            }
        }

        stage('Push Docker Image to Nexus') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'nexus', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {
                    sh "docker login -u admin -p nexus http://192.168.12.150:8083/"
                    //sh "docker login -u admin --password-stdin http://192.168.12.150:8083/ < ~/.docker/config.json"

                }

                script {

                    sh "docker tag java:back 192.168.12.150:8083/${DOCKER_IMAGE_NAME2}:${DOCKER_IMAGE_TAG2}"
                    sh "docker push 192.168.12.150:8083/${DOCKER_IMAGE_NAME2}:${DOCKER_IMAGE_TAG2}"

              }
            }
        }

        stage('Docker-compose') {
                    steps {
                        script {
                            dir(DOCKER_COMPOSE_HOME) {
                                sh 'docker-compose up -d'
                    }
                }
             }
        }



    }

    post {
           always {


                   emailext (
                       subject: "Pipeline de l'Application SpringBoot est terminé avec succés, Succès Jenkins Build ",
                       body: "La construction Jenkins a réussi. Pipeline OK avec succés",
                       to: "rabiica30@gmail.com",
                       from: "jenkins@example.com",
                       replyTo: "jenkins@example.com",
                       mimeType: "text/html"
                   )


               }
     }




}
