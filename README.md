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
