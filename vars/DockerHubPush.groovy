def call(){
  echo 'Pushing the Image to Docker Hub Initiated......'
  withCredentials([usernamePassword(credentialsId:'DockerHubCred',usernameVariable:'DockerHubUser',passwordVariable:'DockerHubPass')]){
  sh 'docker login -u $DockerHubUser -p $DockerHubPass'
  sh 'docker image tag simple-app:latest $DockerHubUser/simple-app:latest'
  sh 'docker push $DockerHubUser/simple-app:latest'
  echo '@@@ Image Pushed to Docker Hub Successfully @@@' 
}
