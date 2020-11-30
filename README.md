## This Android Exercise file is created on 12pm 30-Nov-2020 by Zayar Myo Thwin.

Every exercise notes are noted in this readmefile.
-Context-
Context ဆိုတာက ကြားခံ application environment နဲ့ global information ကိုချိတ်ဆက်ပေးတဲ့ကြားခံ
Context လုပ်လို့ရတဲ့ method တွေက

- 1.getApplicationContext()
- 2.getContext()
- 3.getBaseContext()
- 4.or this(when in the activity class)

  - Examples for uses of context:

    - 1.Creating new objects:Creating new views,adapters,listeners
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
