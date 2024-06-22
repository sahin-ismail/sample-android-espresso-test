package com.denizbank.fastpay.base;


import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.denizbank.fastpay.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class cebe_para_gonder {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test

    public void cebeParaGonder() throws InterruptedException {

        //Dev ortamı seçimi yapılır
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btnDev), withText("DEV"),
                        isDisplayed()));
        appCompatButton.perform(click());

        //Sonraki uygulama tanıtım sayfasına devam et butonu ile geçilir
        for (int i = 0; i < 15; i++) {
            try {
                ViewInteraction appCompatButton2 = onView(
                        allOf(withId(R.id.btnContinue), withText("EN_Devam Et"),
                                isDisplayed()));
                appCompatButton2.perform(click());
                break;
            } catch (NoMatchingViewException e) {
                sleep(500);
                continue;
            }
        }

        //Sonraki uygulama tanıtım sayfasına devam et butonu ile geçilir
        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btnContinue), withText("EN_Devam Et"),
                        isDisplayed()));
        appCompatButton3.perform(click());

        //Sonraki uygulama tanıtım sayfasına devam et butonu ile geçilir
        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btnContinue), withText("EN_Devam Et"),
                        isDisplayed()));
        appCompatButton4.perform(click());

        //Sonraki uygulama tanıtım sayfasına devam et butonu ile geçilir
        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btnContinue), withText("EN_Devam Et"),

                        isDisplayed()));
        appCompatButton5.perform(click());

        //Uygulama tanıtım sayfasındaki kullanmaya başla butonuna tıklanır
        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btnContinue), withText("EN_Kullanmaya Başla"),
                        isDisplayed()));
        appCompatButton6.perform(click());

        //Yeni kayıt tanıtım popupı ekranı kapatılır
        ViewInteraction swipe = onView(withId(R.id.greeting_view));
        swipe.perform(swipeUp());

        //Anasayfa alt tab menüsünden işlemlere tıklanır
        ViewInteraction linearLayout = onView(
                allOf(withId(R.id.btnTransactions),
                        isDisplayed()));
        linearLayout.perform(click());

        //İşlemler sayfasından para gönder seçeneğine tıklanır
        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.tvMenu), withText("EN_Para Gönder"),
                        isDisplayed()));
        appCompatButton7.perform(click());

        //Para gönder sayfasından cebe para gönder seçeneğine tıklanır
        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.tvMenu), withText("EN_Cebe Para Gönder"),
                        isDisplayed()));
        appCompatButton8.perform(click());

        //Şifre ile giriş cep numarası ekranında cep numaran alanına geçmiş işlemleri ve kredi kartı olan kullanıcının numarası girilir
        ViewInteraction textInputAutoCompleteTextView = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.fp_input_layout),
                                0),
                        0),
                        isDisplayed()));
        textInputAutoCompleteTextView.perform(click(), typeText("5346281817"));

        //Şifre ile giriş için cep numarası ekranında devam et butonuna tıklanır
        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.buttonContinue), withText("EN_Devam Et"),
                        isDisplayed()));
        appCompatButton10.perform(click());

        //Şifre ile giriş için şifre ekranında geçmiş işlemleri ve kredi kartı olan kullanıcının şifresi yazılır
        for (int i = 0; i < 15; i++) {
            try {
                ViewInteraction numberInputEditText = onView(
                        allOf(childAtPosition(
                                allOf(withId(R.id.inputPin6),
                                        childAtPosition(
                                                withId(R.id.pagePin),
                                                0)),
                                1),
                                isDisplayed()));
                numberInputEditText.perform(typeText("112233"));
            } catch (NoMatchingViewException e) {
                sleep(500);
            }
        }

        //Şifre ile giriş için otp ekranında geçerli otp girilir
        //Şifre ile giriş için otp ekranında otosubmit uygulanır
        ViewInteraction numberInputEditText2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.inputOtp),
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        1)),
                        1),
                        isDisplayed()));
        numberInputEditText2.perform(typeText("123456"));

        //Login sonrası bildirimler popupında izin verme butonuna tıklanır
        //Cebe para gönder sayfasında rehber erişim izni popupında şimdi değil butonuna tıklanır
        for (int i = 0; i < 15; i++) {
            try {
                ViewInteraction appCompatButton11 = onView(withId(R.id.btnCancel));
                appCompatButton11.perform(click());
            } catch (NoMatchingViewException e) {
                sleep(500);
            }
        }

        //Cebe para gönder sayfasında cep no alanına geçerli cep no yazılır
        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.contactSelector),
                        childAtPosition(
                                withId(R.id.formField),
                                2)));
        recyclerView3.perform(actionOnItemAtPosition(0, click()));

        //Cebe para gönder sayfasında tutar alanına gönderilebilir tutar yazılır
        ViewInteraction editText = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                childAtPosition(
                                        childAtPosition(
                                                withId(R.id.inputAmount),
                                                0),
                                        0),
                                0),
                        0),
                        isDisplayed()));
        editText.perform(click(), typeText("2"), closeSoftKeyboard());

        ViewInteraction swipe2 = onView(
                allOf(withId(R.id.contactSelector)
                ));
        swipe2.perform(swipeUp());

        //Cebe para gönder sayfasında açıklama alanına bir açıklama yazılır
        ViewInteraction editText2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                childAtPosition(
                                        childAtPosition(
                                                withId(R.id.inputDescription),
                                                0),
                                        0),
                                0),
                        0),
                        isDisplayed()));
        editText2.perform(click(), typeText("test"), closeSoftKeyboard());

        ViewInteraction swipe3 = onView(
                allOf(withId(R.id.contactSelector)
                ));
        swipe3.perform(swipeUp());

        //Cebe para gönder sayfasında devam butonuna tıklanır
        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.btnContinue)));
        appCompatButton9.perform(click());

        //Cebe para gönder işlem onay sayfasında işlemi onayla butonun tıklanır
        for (int i = 0; i < 15; i++) {
            try {
                ViewInteraction appCompatButton12 = onView(
                        allOf(withId(R.id.summary_button_2)));
                appCompatButton12.perform(click());
            } catch (NoMatchingViewException e) {
                sleep(500);
            }
        }

        //Cebe para gönder başarılı işlem sayfasının açıldığı kontrol edilir
        for (int i = 0; i < 15; i++) {
            try {
                ViewInteraction ImageView = onView(
                        allOf(withId(R.id.imgSuccess)));
                ImageView.check(matches(isDisplayed()));
            } catch (NoMatchingViewException e) {
                sleep(500);
            }
        }


    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

}
