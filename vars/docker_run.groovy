def call(String imageTag, String port){
  echo "Running Docker Container Initialize"
  sh "docker run -d -p ${port}:${port} ${imageTag}"
  echo "Docker Container is now Running..."
}
