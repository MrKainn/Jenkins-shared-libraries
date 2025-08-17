def call(String url, String branch){
  echo "Cloning the Code initiated ......"
  git url:"${url}", branch:"${branch}"
  echo "@@@ Code Cloned Successfully @@@"
}
