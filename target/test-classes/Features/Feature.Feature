Feature:Login

Background: Run all the steps for all Scanerio
Given User wants to pass the user credentials
|http://automationpractice.com/index.php|




@NewUserCreation
Scenario Outline: CreateAccount_User
Then user is required to pass the credentials "<FirstName>" , "<UserLastName>" , "<Password>" 
|4|3|2021|263,12343|Panchkula|Alaska|
And User has to pass rest of the details "<zipCode_Passed>" ,"<Mobile_NumPassed>"
And verify the account creation is successful
Then Logout user 



Examples:
|FirstName|UserLastName|Password|zipCode_Passed|Mobile_NumPassed|
|Nipun|Verma|ABCD@12991$$|00000|987456985|





@NewUserCreation_UpdatedData
Scenario Outline: CreateAccount
Then user is required to pass the credentials "<FirstName>" , "<UserLastName>" , "<Password>" 
|5|4|2021|266,12555|Chandigarh|Alaska|
And User has to pass rest of the details "<zipCode_Passed>" ,"<Mobile_NumPassed>"
And verify the account creation is successful
Then Logout user 



Examples:
|FirstName|UserLastName|Password|zipCode_Passed|Mobile_NumPassed|
|Nipun|Verma|ABCD@12991$$|00000|987456985|








@ExistingUser
Scenario Outline: ExistingUser 
Then user wants to pass the existing user credentials "<ExsitingUserFirstName>" ,"<ExisitingUserLastName>"
And verify the account creation is successful
Then Logout user 


Examples:
|FirstName|UserLastName|Password|zipCode_Passed|Mobile_NumPassed|ExsitingUserFirstName|ExisitingUserLastName|
|Nipun|Verma|ABCD@12991$$|00000|987456985|Dummy_User@test.com|Dummy_User@test.com|







