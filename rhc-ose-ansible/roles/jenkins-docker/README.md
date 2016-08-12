# Jenkins Docker Image

This role creates a jenkins service in a docker container that has access to the docker daemon on the host machine. It also allows for global security configured with ldap and provides some customizations such as:
  * A fixed ssh port
  * A specific set of plugins
  * A git tool defined
  * A maven tool defined
  * A nodejs tool defined
  * Jenkins workflow preconfigured through git 
  * An scriptApproval.xml to predefined approved signatures (workflow)

Checkout out https://github.com/rht-labs/jenkins-global-pipeline-library.git for a sample of how workflow can be implementedo

### Notes on inventory variables and deployment

* the variable jenkins_host_url can be left to localhost in most cases as the script will be run on the deployed server
* Be careful with the ldap variables. You can't use & or `&amp;` instead use \u0026
* is likely that the user id 1000 needs access to the jenkins home directory as the official docker image that this is based on sets that by default
* is likely that the group 1001 will be needed to access docker from the jenkins container and this is set in the Red Hat Labs docker image
* Ensure your docker client matches the host and the guest container
  
A separate Jenkins could be started in the cicd role  
