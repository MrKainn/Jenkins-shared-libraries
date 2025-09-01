def call(String url, String branch){
  cleanWs()
  echo "Cloning the Code initiated ......"
  git url:"${url}", branch:"${branch}"
  echo "@@@ Code Cloned Successfully @@@"
}
