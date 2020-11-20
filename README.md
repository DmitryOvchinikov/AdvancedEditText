[![](https://jitpack.io/v/DmitryOvchinikov/AdvancedEditText.svg)](https://jitpack.io/#DmitryOvchinikov/AdvancedEditText)

## Table of Contents  
* [Usage](https://github.com/DmitryOvchinikov/AdvancedEditText/blob/master/README.md#usage)  
* [Integration](https://github.com/DmitryOvchinikov/AdvancedEditText/blob/master/README.md#integration)  
* [How To Use](https://github.com/DmitryOvchinikov/AdvancedEditText/blob/master/README.md#how-to-use)  
  * [Via Attributes](https://github.com/DmitryOvchinikov/AdvancedEditText/blob/master/README.md#via-attributes)
  * [Programmatically](https://github.com/DmitryOvchinikov/AdvancedEditText/blob/master/README.md#programmatically)
* [Available methods](https://github.com/DmitryOvchinikov/AdvancedEditText/blob/master/README.md#available-methods)  
* [License](https://github.com/DmitryOvchinikov/AdvancedEditText/blob/master/README.md#license)   

## Usage
  A small android library that allows easy EditText validations.
  
## Integration  
  
  Add it in your root build.gradle at the end of repositories:
```css  
   allprojects {  
      repositories {  
         ...  
         maven { url 'https://jitpack.io' }  
      }  
   }  
```  
Add the dependency:
```css  
   dependencies {  
	     implementation 'com.github.DmitryOvchinikov:AdvancedEditText:1.0.0'
   }  
```  

## How To Use
### Via Attributes
**1.** Utilize the attributes when creating the AdvancedEditText instance:
```XML  
    <com.android.advancedet.AdvancedEditText
        android:id="@+id/example"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:checkNotEmpty="true"
        app:notEmptyError="Not empty!"
        app:checkCustom="true"
        app:customPattern="[abc]"
        />
```
**2.** Validate the AdvancedEditText via the check() method:
```Java  
    AdvancedEditText example = findViewById(R.id.example);
    example.check();
```
### Programmatically
Programmatically setup your AdvancedEditText after creating an instance in the XML:
```Java
    AdvancedEditText example = findViewById(R.id.example);
    example.checkNotEmpty("Your error message");
    example.checkMaximum(20, "Your error message");
```

## Available methods
- **check()**: going over all the required checks that are created via the attributes
- **checkNotEmpty()**: checks if the text is not empty
- **checkMaximum()**: checks if the text exceeds your custom amount of chars
- **checkMinimum()**: checks if the amount of chars in the text is below your custom amount
- **checkEmail()**: checks if the text is an email
- **checkCustom()**: checks the text against your custom pattern

## License   
  
```  
Copyright 2020 Dmitry Ovchinikov  
  
Licensed under the Apache License, Version 2.0 (the "License");  
you may not use this file except in compliance with the License.  
You may obtain a copy of the License at  
  
https://github.com/DmitryOvchinikov/AdvancedEditText/blob/master/LICENSE  
  
Unless required by applicable law or agreed to in writing, software  
distributed under the License is distributed on an "AS IS" BASIS,  
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
See the License for the specific language governing permissions and  
limitations under the License.  
```
