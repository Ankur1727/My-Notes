package com.mynotes.notes;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Practice_Class extends Practice_2  {
    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        main();

        return super.onCreateView(name, context, attrs);
    }

    @Override
    void main() {
        //arrayRevese();
        //stringRevese();
        //numberInteger();
        //bigestValueFromArray();
      // primeNumber();
      //  reverseInbuiltFuction();
      //  reveseUsingDynamice_Input();
       // swipingTwoNumberWithThird();
      //  swipingTwoNumberWitout_Third();
        //palindrome();
        fibonaci_Series();

    }

}

