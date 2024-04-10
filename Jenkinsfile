pipeline {
    agent any

    environment {
        NEXUS_URL = 'http://192.168.164.129:8081/repository/maven-releases/'
        DOCKER_REPO = 'rabii1990/backend'
        DOCKERFILE_PATH = '/var/lib/jenkins/workspace/pfeb/Dockerfile'
        DOCKER_IMAGE_NAME = 'rabiiback'
        DOCKER_IMAGE_TAG = 'spring'
        NEXUS_USERNAME = 'admin'
        NEXUS_PASSWORD = 'nexus'

        DOCKER_IMAGE_NAME2 = 'rabiiback2'
        DOCKER_IMAGE_TAG2 = 'spring2'
        passwordFile = 'password.txt'

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

        stage('Code Coverage with Jacoco') {
           steps {
                script {
                    sh 'mvn jacoco:prepare-agent test jacoco:report'
               }
                jacoco(execPattern: 'target/jacoco.exec')
            }
        }

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

                sh 'chmod 750 /var/lib/jenkins/workspace/pfeb/target/springboot-crud-api-0.1.jar'
                sh 'chmod 777 /var/lib/jenkins/workspace/pfeb/Dockerfile'
                sh 'chmod 777 /var/lib/jenkins/workspace/pfeb/docker-compose.yml'
                sh "docker build -t java:back /var/lib/jenkins/workspace/pfeb "
            }
        }

        stage {
               stage('Scanner avec TRIVY') {
                   steps {
                       sh 'trivy image --timeout 60m --output /home/trivy-report.txt java:back'
                   }
               }
             }

        stage('Send Trivy Report by Email') {
                   steps {
                       emailext subject: 'Trivy Security Scan Report',
                           body: 'Please find attached the Trivy security scan report.',
                           attachmentsPattern: '/home/trivy-report.txt',
                           to: 'rabiica30@gmail.com'
            }
        }


        stage('Push Docker Image to Docker Hub') {
            steps {
                sh "docker tag java:back ${DOCKER_REPO}:${DOCKER_IMAGE_TAG}"
                sh "docker login -u rabii1990 -p rabiiradar2012"
                sh "docker push ${DOCKER_REPO}:${DOCKER_IMAGE_TAG}"
            }
        }

        stage('Push de l\'image Docker vers Nexus') {
            steps {
                // Récupération sécurisée des identifiants avec le plugin UsernamePassword
                withCredentials([usernamePassword(credentialsId: 'nexus', usernameVariable: 'NEXUS_USERNAME', passwordVariable: 'NEXUS_PASSWORD')]) {

                    // Connexion à Nexus avec --password-stdin
                    sh '''
                        docker login -u '${NEXUS_USERNAME}' --password-stdin <<< '${NEXUS_PASSWORD}' 192.168.164.129:8083
                    '''

                    // Étiquetage et push de l'image
                    script {
                        def image = "${env.DOCKER_IMAGE_NAME2}:${env.DOCKER_IMAGE_TAG2}"
                        docker.withRegistry('https://192.168.164.129:8083', 'nexus') {
                            docker.buildAndPush(image)
                        }
                    }
                }
            }
        }






       // stage('Docker-compose') {
       //             steps {
       //                 script {
       //                     dir(DOCKER_COMPOSE_HOME) {
       //                         sh 'docker-compose up -d'
       //             }
       //         }
       //      }
       // }



    }

   // post {
        //   always {


          //         emailext (
           //            subject: "Pipeline de l'Application SpringBoot est terminé avec succés, Succès Jenkins Build ",
           //            body: "La construction Jenkins a réussi. Pipeline OK avec succés",
           //            to: "rabiica30@gmail.com",
           //            from: "jenkins@example.com",
           //            replyTo: "jenkins@example.com",
           //            mimeType: "text/html"
           //        )


          //     }
    // }




}
