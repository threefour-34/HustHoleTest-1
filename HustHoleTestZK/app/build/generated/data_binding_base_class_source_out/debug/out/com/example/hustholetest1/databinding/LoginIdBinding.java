// Generated by view binder compiler. Do not edit!
package com.example.hustholetest1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.hustholetest1.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LoginIdBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText EditText;

  @NonNull
  public final Button button4;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView11;

  @NonNull
  public final TextView textView12;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textView9;

  private LoginIdBinding(@NonNull ConstraintLayout rootView, @NonNull EditText EditText,
      @NonNull Button button4, @NonNull LinearLayout linearLayout, @NonNull TextView textView10,
      @NonNull TextView textView11, @NonNull TextView textView12, @NonNull TextView textView3,
      @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6,
      @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9) {
    this.rootView = rootView;
    this.EditText = EditText;
    this.button4 = button4;
    this.linearLayout = linearLayout;
    this.textView10 = textView10;
    this.textView11 = textView11;
    this.textView12 = textView12;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.textView6 = textView6;
    this.textView7 = textView7;
    this.textView8 = textView8;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LoginIdBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LoginIdBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.login_id, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LoginIdBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.EditText;
      EditText EditText = rootView.findViewById(id);
      if (EditText == null) {
        break missingId;
      }

      id = R.id.button4;
      Button button4 = rootView.findViewById(id);
      if (button4 == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = rootView.findViewById(id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = rootView.findViewById(id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView11;
      TextView textView11 = rootView.findViewById(id);
      if (textView11 == null) {
        break missingId;
      }

      id = R.id.textView12;
      TextView textView12 = rootView.findViewById(id);
      if (textView12 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = rootView.findViewById(id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = rootView.findViewById(id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = rootView.findViewById(id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = rootView.findViewById(id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = rootView.findViewById(id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = rootView.findViewById(id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = rootView.findViewById(id);
      if (textView9 == null) {
        break missingId;
      }

      return new LoginIdBinding((ConstraintLayout) rootView, EditText, button4, linearLayout,
          textView10, textView11, textView12, textView3, textView4, textView5, textView6, textView7,
          textView8, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}