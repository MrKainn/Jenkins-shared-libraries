def call(String url, String branch){
  echo "Cloning the Code initiated ......"
  git tool:"LinuxGit", url:"${url}", branch:"${branch}"
  echo "@@@ Code Cloned Successfully @@@"
}
