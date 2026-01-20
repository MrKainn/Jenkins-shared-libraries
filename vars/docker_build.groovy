def call(String imagetag, String file_path){
  echo "Building docker image: ${imagetag}"
  sh "docker build -t ${imagetag} -f ${file_path} --no-cache ."
  echo "${imagetag} Build sccessfully..."
}
