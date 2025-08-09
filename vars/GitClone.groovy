def call(string url, string branch){
  echo "Cloning the Code initiated ......"
  git url:"${url}", branch:"${branch}"
  echo "@@@ Code Cloned Successfully @@@"
}
