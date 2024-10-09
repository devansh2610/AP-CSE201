--------------------------------------------------------------
-admin user: admin
-admin password: admin123
-All attractions are open by default when added. 
-All attractions have a default ticket price of Rs. 10.
-Visitors need to enter a minimum balance of Rs. 100 when registering.
-A visitor with an existing membership cannot buy a new membership.
-2 mammals, 2 reptiles, 2 amphibians are hard coded as in the instructions (they can be modified)
-2 special deals are hard coded as in the instructions
-2 discounts are hard coded as in the instructions (they can be modified)
-Discounts are stacked, i.e., both special deals and discount coupon are applied if applicable.
-Total visitors = no. of basic users + no. of premium users (as mentioned in the classroom instructions)
-Attractions and animals cannot be visited if the user has not purchased a form of membership.
-Classes, subclasses, interfaces, abstract classes, polymorphism, Object class and methods like toString, instance of have been used.
-Mostly all variables in classes are private and have getters and setters unless otherwise requires specifically in the code (for example public static variables
 to maintain UID count)
-Discount codes are not case sensitive (for ease of checking)
-Discount codes are automatically generated based on category and percentage input in the form of a string: "CATEGORY" + "PERCENTAGE" (for ex SENIOR20)
-Discount codes are applied based on Categories which are in turn based on ages (<18 Minor, >=18 and <=24 Student, >=25 and <=60 Working, >60 Senior)


--------------------------------------------------------------
HOME_FOLDER = Assignment2

All the commands should be run on the terminal in the HOME_FOLDER unless otherwise specified.
In case of build failure, please run mvn clean install first in HOME_FOLDER. 

0) Download the src code folder from Classroom and unzip.
1) mvn clean 
2) mvn compile
3) mvn package
4) cd target
5) java -jar Assignment2-1.0-SNAPSHOT.jar
