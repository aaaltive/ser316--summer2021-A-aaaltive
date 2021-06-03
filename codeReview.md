# Code Review Defect List
 
**Reviewer:**
 > Armand Altiveros

**GH Repo:**
 > ser316--summer2021-A-aaaltive

| ID#   | Location  | Problem Description   | Category  | Severity  |
|:---:|---|---|:---:|:---:|
|1|globally|All public class does not have filled class banner|CG2|LOW|
|2|globally|Almost all public methods do not have filled banners|CG3|LOW|
|3|class Environment; line 46|enums of type Weather is not in all caps|CG4a|LOW|
|4|class Environment; line 3|variable WEATHER should not be all caps|CG4c|LOW|
|5|globally|all attributes are public|CG5|MJ|
|6|class Mascotmon; line78, 82, 85...|literals used rather than constants|CG6|LOW|
|7|class Attack|this class doesn't really do anything except construct an Attack object|CS5|LOW|
|8|class Mascotmon constructor and Class Description|pointless to have this as it's own class and used only and every time the constructor is called in Mascotmon, this should be thier home|CS4|LOW|
|9|class Mascotmon|no getter or setter for weatherBonus or typeBonus|FD|BR|

## Category:	
 - CS – Code Smell defect. 
 - CG – Violation of a coding guideline. Provide the guideline number. 
 - FD – Functional defect. Code will not produce the expected result. 
 - MD – Miscellaneous defect, for all other defects.
##  Severity:       
 - BR - Blocker, must be fixed asap. 
 - MJ – Major, of high importance but not a Blocker 
 - LOW – Low.