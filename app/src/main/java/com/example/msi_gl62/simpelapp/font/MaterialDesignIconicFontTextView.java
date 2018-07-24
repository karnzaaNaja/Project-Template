package com.example.msi_gl62.simpelapp.font;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class MaterialDesignIconicFontTextView extends AppCompatTextView {

	private static Typeface sIconicIcons;

	public MaterialDesignIconicFontTextView(Context context) {
		this(context, null);
	}

	public MaterialDesignIconicFontTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MaterialDesignIconicFontTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if (isInEditMode()) return;//Won't work in Eclipse graphical layout
		setTypeface();
	}
	
	private void setTypeface() {
		if (sIconicIcons == null) {
			sIconicIcons = Typeface.createFromAsset(getContext().getAssets(), "fonts/Material-Design-Iconic-Font.ttf");
		}
		setTypeface(sIconicIcons);
	}

}
