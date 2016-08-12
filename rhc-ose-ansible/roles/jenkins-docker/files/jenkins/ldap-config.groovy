import jenkins.model.*
import hudson.security.*
import org.jenkinsci.plugins.*
import hudson.security.FullControlOnceLoggedInAuthorizationStrategy

String server = "ldaps://idm-1.etl.lab.eng.rdu2.redhat.com:636"
String rootDN = "dc=etl,dc=lab,dc=eng,dc=rdu2,dc=redhat,dc=com"
String userSearchBase = ""
String userSearch = "(\u0026(uid={0})(memberOf=cn=rhoil_admins,cn=groups,cn=accounts,dc=etl,dc=lab,dc=eng,dc=rdu2,dc=redhat,dc=com))"
String groupSearchBase = ""
String managerDN = "uid=rhoil_ldap,cn=users,cn=accounts,dc=etl,dc=lab,dc=eng,dc=rdu2,dc=redhat,dc=com"
String managerAccess = "ldap01"
boolean inhibitInferRootDN = true

SecurityRealm ldapRealm = new LDAPSecurityRealm(server, rootDN, userSearchBase, userSearch, groupSearchBase, managerDN, managerAccess, inhibitInferRootDN)
Jenkins.instance.setSecurityRealm(ldapRealm)
Jenkins.instance.setAuthorizationStrategy(new FullControlOnceLoggedInAuthorizationStrategy())
Jenkins.instance.save()
