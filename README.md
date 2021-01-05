## This Android Exercise file is created on 12pm 30-Nov-2020 by Zayar Myo Thwin.

### Context
Context ဆိုတာက ကြားခံ application environment နဲ့ global information ကိုချိတ်ဆက်ပေးတဲ့ကြားခံ
Context လုပ်လို့ရတဲ့ method တွေက

1. getApplicationContext()
2. getContext()
3. getBaseContext()
4. or this(when in the activity class)

  - Examples for uses of context:

    1. Creating new objects:Creating new views,adapters,listeners
 ``` java
    TextView tv=new TextView(getContext());
    ListAdapter adapter=new SimpleCursorAdapter(getApplicationContext());
 ```


* Activity ထဲမှာ view တွေကို dynamically create လုပ်တဲ့အခါမှ context ကိုလိုအပ်တယ်။
ဉပမာ-code ကနေပီးတော့ TextView ကိုဖန်တီးမယ်ဆိုရင် TextView ရဲ့ constructor က context object ကိုယူလိုက်တယ် ဘာလို့လဲဆိုရင် Activity class က Context ရဲ့ subclass ဖစ်‌ေနလို့။
* Context Object က application ရဲ့ resources တွေနဲ့ တခြား features တွေကိုရအောင်ထောက်ပံပေးတယ်။
* Activity တိုင်းက Context ဖစ်ပီးတော့ View တိုင်းက Context ကိုလိုအပ်တယ်။
### Difference between Activity Context and Appliaction Context
![Context](context.png)
* Need of Context:
  * View တိုင်းဟာ မှန်ကန်တဲ့ resources(eg.the theme,strings etc) ‌ေတွရရှိဖို့အတွက် context ကိုလိုအပ်တယ်။

### Intents and Filters
Android Intent ဆိုတာလုပ်‌ေဆာင်ရမယ့် operation အတွက်အကျဉ်းချုပ်‌ေဖာ်ပြချက်ဘဲဖစ်တယ်။ဘလိုမျိုးသံုးလို့ရလဲဆိုရင် Activity တစ်ခုကိုစဖို့အတွက် startActivity မှာသုံးလို့ရမယ်။ broadcastIntent , startService(Intent) or bindService(Intent, ServiceConnection, int)  စတဲ့ backgroud service ‌ေတွနဲ့ချိတ်ဆက်တဲ့အခါမှာလဲသုံးလို့ရတယ်။
* ဉပမာ-Activity တခုရှိတယ် အဲ့ Activity က email client တခုကို email ပို့တဲ့ဟာဆိုပါဆို့    Activity က ACTION_SEND ဆိုတာကို Android Intent resolver ထဲကိုပို့လိုက်မယ်။
``` java
Intent email=new Intent(Intent.ACTION_SEND,Uri.parse("mailto:"));
email.putExtra(Intent.EXTRA_EMAIL,recipients);
email.putExtra(Intent.EXTRA_SUBJECT,subject.getText().toString());
email.putExtra(Intent.EXTRA_TEXT,body.getText().toString());
startActivity(Intent);
```

### Action
Action ဆိုတာက Intent object ရဲ့ မဖစ်မ‌ေနလုပ်ရ‌ေသာအစိတ်အပိုင်း။ ACTION_VIEW,ACTION_DIAL စတာ‌ေတွ။

### Data
Intent filter ထဲကို data specification ‌ေတွထည့်တာ 

## Types of Intents
Explicit Intent နဲ့ Implicit Intent ဆိုပီးနှစ်မျိုးရှိပါတယ်။
![Typesofintents](intent.png)

### Explicit Intents
First Activity က‌ေန Second Activity ကိုသွားတာကို Explicit Intentလို့‌ေခါ်တယ်
``` java
//Explicit Intent by specifying its class name
Intent i=new Intent(FirstActivity.class,SecondActivity.class)
//starts Target Activity
startActivity(i);
```
### Implicit Intents
Implicit Intent ကကျ‌ေတာ့ အခြား applications ‌ေတွမှာ component ‌ေတွကို activate လုပ်တဲ့အခါမျိုးမှာသုံးတယ်။
``` java
Intent read1=new Intent();
read1.setAction(android.content.Intent.ACTION_VIEW);
read1.setData(ContactsContract.Contact.CONTENT_URI);
startActivity(read1);
```
### Function of Intent နဲ့ Custom Browser ဖွင့်တဲ့ app ကို Example 1 မှာရေးထားတယ်
* Function of Intent ထဲမှာတော့ Intent ကိုအသုံးပြုပီး website တခုဖွင့်တာနဲ့ Phone call တခုခေါ်တာကိုပြပေးထားတယ်
* Custom Browser မှာတော့ ကိုယ်ပိုင် app မှာ Browser ဖွင့်တဲ့ပုံစံလုပ်ထားတယ် Browser name ရိုက်ထည့်ရတဲ့ text box မှာတော့ http://www.google.com ဘာညာဆိုပီး ပြည့်ပြည့်စုံစုံရိုက်ထည့်ပေးဖို့လိုအပ်တယ်။

### Intent Filters
Android OS filters များကိုအသုံးပြုပီးတော့ Activites,Servies,Broadcast receivers တွေနဲ့သက်ဆိုင်တဲ့ action,categories,data scheme တွေကိုရေးရတယ်။<intent-filter></intent-filter> element ကိုအသုံးပြုပီးတော့ activies,services,broadcaste receivers တွေနဲ့သက်ဆိုင်တဲ့ action,categories,data scheme တွေအဖစ် android manifest file ထဲမှာသွားပီးရေးထည့်ပေးရတယ်။ Intent-filter ထည့်ရေးထားတဲ့ဉပမာက 
``` xml
 <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <data android:scheme="http://"/>
                <data android:scheme="https://"/>
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />

            </intent-filter>
        </activity>
```
### Activites
Android မှာ activity ဆိုတာ screen မှာမြင်ရတဲ့ screen တခုကိုဆိုလိုတယ်။activity တခုကို onCreate() ဆိုတဲ့ method နဲ့စတယ်။
![Activity Life Cycle](activity.jpg)
