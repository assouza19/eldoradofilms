// Generated by view binder compiler. Do not edit!
package com.br.eldoradofilms.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.br.eldoradofilms.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LottieAnimationView loadingMostPopular;

  @NonNull
  public final ItemsMenuBinding menuActions;

  @NonNull
  public final RecyclerView mostPopularList;

  @NonNull
  public final TextView mostPopularTitle;

  @NonNull
  public final SearchView searchBar;

  @NonNull
  public final TextView upcomingTitle;

  private FragmentHomeBinding(@NonNull ConstraintLayout rootView,
      @NonNull LottieAnimationView loadingMostPopular, @NonNull ItemsMenuBinding menuActions,
      @NonNull RecyclerView mostPopularList, @NonNull TextView mostPopularTitle,
      @NonNull SearchView searchBar, @NonNull TextView upcomingTitle) {
    this.rootView = rootView;
    this.loadingMostPopular = loadingMostPopular;
    this.menuActions = menuActions;
    this.mostPopularList = mostPopularList;
    this.mostPopularTitle = mostPopularTitle;
    this.searchBar = searchBar;
    this.upcomingTitle = upcomingTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.loadingMostPopular;
      LottieAnimationView loadingMostPopular = rootView.findViewById(id);
      if (loadingMostPopular == null) {
        break missingId;
      }

      id = R.id.menu_actions;
      View menuActions = rootView.findViewById(id);
      if (menuActions == null) {
        break missingId;
      }
      ItemsMenuBinding binding_menuActions = ItemsMenuBinding.bind(menuActions);

      id = R.id.mostPopularList;
      RecyclerView mostPopularList = rootView.findViewById(id);
      if (mostPopularList == null) {
        break missingId;
      }

      id = R.id.mostPopularTitle;
      TextView mostPopularTitle = rootView.findViewById(id);
      if (mostPopularTitle == null) {
        break missingId;
      }

      id = R.id.searchBar;
      SearchView searchBar = rootView.findViewById(id);
      if (searchBar == null) {
        break missingId;
      }

      id = R.id.upcomingTitle;
      TextView upcomingTitle = rootView.findViewById(id);
      if (upcomingTitle == null) {
        break missingId;
      }

      return new FragmentHomeBinding((ConstraintLayout) rootView, loadingMostPopular,
          binding_menuActions, mostPopularList, mostPopularTitle, searchBar, upcomingTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
