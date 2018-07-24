package com.example.msi_gl62.simpelapp.font;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class GoogleMaterialDesignIconsTextView extends AppCompatTextView {

	private static Typeface fontIcons;

	public GoogleMaterialDesignIconsTextView(Context context) {
		this(context, null);
	}

	public GoogleMaterialDesignIconsTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public GoogleMaterialDesignIconsTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if (isInEditMode()) return;//Won't work in Eclipse graphical layout
		setTypeface();
	}
	
	private void setTypeface() {
		if (fontIcons == null) {
			fontIcons = Typeface.createFromAsset(getContext().getAssets(), "fonts/MaterialIcons-Regular.ttf");
		}
		setTypeface(fontIcons);
	}

}
