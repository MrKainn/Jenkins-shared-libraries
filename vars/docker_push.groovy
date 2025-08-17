def call(String Project, String Imagetag, String DockerHubUser){
  echo 'Pushing the Image to Docker Hub Initiated......'
  withCredentials([usernamePassword(credentialsId:'DockerHubCred',usernameVariable:'DockerHubUser',passwordVariable:'DockerHubPass')]){
  sh 'docker login -u $DockerHubUser -p $DockerHubPass'
  sh 'docker image tag $Project:latest $DockerHubUser/$Project:latest'
  sh 'docker push $DockerHubUser/$Project:$Imagetag'
  echo '@@@ Image Pushed to Docker Hub Successfully @@@' 
}
