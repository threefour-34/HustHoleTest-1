// Generated by view binder compiler. Do not edit!
package com.example.hustholetest1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.hustholetest1.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class Page2fragmentBinding implements ViewBinding {
  @NonNull
  private final SmartRefreshLayout rootView;

  @NonNull
  public final SmartRefreshLayout refreshLayout;

  @NonNull
  public final ImageView textView16;

  @NonNull
  public final TextView textView18;

  private Page2fragmentBinding(@NonNull SmartRefreshLayout rootView,
      @NonNull SmartRefreshLayout refreshLayout, @NonNull ImageView textView16,
      @NonNull TextView textView18) {
    this.rootView = rootView;
    this.refreshLayout = refreshLayout;
    this.textView16 = textView16;
    this.textView18 = textView18;
  }

  @Override
  @NonNull
  public SmartRefreshLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static Page2fragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static Page2fragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.page2fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static Page2fragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      SmartRefreshLayout refreshLayout = (SmartRefreshLayout) rootView;

      id = R.id.textView16;
      ImageView textView16 = rootView.findViewById(id);
      if (textView16 == null) {
        break missingId;
      }

      id = R.id.textView18;
      TextView textView18 = rootView.findViewById(id);
      if (textView18 == null) {
        break missingId;
      }

      return new Page2fragmentBinding((SmartRefreshLayout) rootView, refreshLayout, textView16,
          textView18);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}