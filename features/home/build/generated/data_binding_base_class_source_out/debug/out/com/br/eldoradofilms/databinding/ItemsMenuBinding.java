// Generated by view binder compiler. Do not edit!
package com.br.eldoradofilms.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.br.eldoradofilms.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemsMenuBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatImageButton iconCinema;

  @NonNull
  public final AppCompatImageButton iconGenres;

  @NonNull
  public final AppCompatImageButton iconMovies;

  @NonNull
  public final AppCompatImageButton iconTv;

  @NonNull
  public final TextView textCinema;

  @NonNull
  public final TextView textGenres;

  @NonNull
  public final TextView textMovies;

  @NonNull
  public final TextView textTv;

  private ItemsMenuBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatImageButton iconCinema, @NonNull AppCompatImageButton iconGenres,
      @NonNull AppCompatImageButton iconMovies, @NonNull AppCompatImageButton iconTv,
      @NonNull TextView textCinema, @NonNull TextView textGenres, @NonNull TextView textMovies,
      @NonNull TextView textTv) {
    this.rootView = rootView;
    this.iconCinema = iconCinema;
    this.iconGenres = iconGenres;
    this.iconMovies = iconMovies;
    this.iconTv = iconTv;
    this.textCinema = textCinema;
    this.textGenres = textGenres;
    this.textMovies = textMovies;
    this.textTv = textTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemsMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemsMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.items_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemsMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iconCinema;
      AppCompatImageButton iconCinema = rootView.findViewById(id);
      if (iconCinema == null) {
        break missingId;
      }

      id = R.id.iconGenres;
      AppCompatImageButton iconGenres = rootView.findViewById(id);
      if (iconGenres == null) {
        break missingId;
      }

      id = R.id.iconMovies;
      AppCompatImageButton iconMovies = rootView.findViewById(id);
      if (iconMovies == null) {
        break missingId;
      }

      id = R.id.iconTv;
      AppCompatImageButton iconTv = rootView.findViewById(id);
      if (iconTv == null) {
        break missingId;
      }

      id = R.id.textCinema;
      TextView textCinema = rootView.findViewById(id);
      if (textCinema == null) {
        break missingId;
      }

      id = R.id.textGenres;
      TextView textGenres = rootView.findViewById(id);
      if (textGenres == null) {
        break missingId;
      }

      id = R.id.textMovies;
      TextView textMovies = rootView.findViewById(id);
      if (textMovies == null) {
        break missingId;
      }

      id = R.id.textTv;
      TextView textTv = rootView.findViewById(id);
      if (textTv == null) {
        break missingId;
      }

      return new ItemsMenuBinding((ConstraintLayout) rootView, iconCinema, iconGenres, iconMovies,
          iconTv, textCinema, textGenres, textMovies, textTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}