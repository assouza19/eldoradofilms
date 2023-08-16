// Generated by view binder compiler. Do not edit!
package com.br.eldoradofilms.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.br.eldoradofilms.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemMostPopularBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final AppCompatImageView filmImagePreview;

  @NonNull
  public final CardView mostPopularCard;

  @NonNull
  public final TextView mostPopularFilmNote;

  private ItemMostPopularBinding(@NonNull CardView rootView,
      @NonNull AppCompatImageView filmImagePreview, @NonNull CardView mostPopularCard,
      @NonNull TextView mostPopularFilmNote) {
    this.rootView = rootView;
    this.filmImagePreview = filmImagePreview;
    this.mostPopularCard = mostPopularCard;
    this.mostPopularFilmNote = mostPopularFilmNote;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemMostPopularBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemMostPopularBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_most_popular, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemMostPopularBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.filmImagePreview;
      AppCompatImageView filmImagePreview = rootView.findViewById(id);
      if (filmImagePreview == null) {
        break missingId;
      }

      CardView mostPopularCard = (CardView) rootView;

      id = R.id.mostPopularFilmNote;
      TextView mostPopularFilmNote = rootView.findViewById(id);
      if (mostPopularFilmNote == null) {
        break missingId;
      }

      return new ItemMostPopularBinding((CardView) rootView, filmImagePreview, mostPopularCard,
          mostPopularFilmNote);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}