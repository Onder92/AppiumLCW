Specification Heading
=====================
Created by testinium on 2.03.2022

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Login Page
----------------
*xpath'li "//*[@text='Profil']" elemente tıkla
*"2" saniye bekle
*id'li "com.lcwaikiki.android:id/headerLogin" elementi bul ve text "GİRİŞ YAP" alanını kontrol et
*id'li "com.lcwaikiki.android:id/edtEmail" elementi bul ve "ondery@testinium.com" değerini yaz
*id'li "com.lcwaikiki.android:id/edtPassword" elementi bul ve "123456" değerini yaz
*id'li "com.lcwaikiki.android:id/buttonLogin" elemente tıkla