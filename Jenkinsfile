node (){
stage 'Build and Test'
env.PATH = "${tool 'M3'}/bin:${env.PATH}"
//checkout scm
git url:"https://github.com/tobecrazy/SeleniumDemo.git"
echo "start building"
echo ${test}
mvn clean
mvn compile
mvn test
mvn findbugs:findbugs
echo "end building"
}
