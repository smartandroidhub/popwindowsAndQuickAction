
package com.kamalv.testcheck;

 
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final int ID_ADD = 1;
	private static final int ID_ACCEPT = 2;
	public int i,j;
	 LinearLayout parentview;
	LayoutInflater maintimeline;
	View maintimelineview ;
	LinearLayout mainlinear,childlinear;
	private static final int ID_UPLOAD = 3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addviews(15);
	}

	private void addviews(int parentnum) {
		// TODO Auto-generated method stub
		  mainlinear=(LinearLayout)findViewById(R.id.linear);
		  childlinear=  (LinearLayout)findViewById(R.id.childlinear);
		  
		  parentview=new LinearLayout(MainActivity.this);
		 LayoutParams parentviewparams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		 parentview.setLayoutParams(parentviewparams);
		
		for(i=1;i<parentnum;i++){
		
	  maintimeline = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		  maintimelineview = maintimeline.inflate(R.layout.row, null);
		  
		  
		  if(i==5){
				 maintimelineview.setBackgroundResource(R.drawable.ic_add);
				 maintimelineview.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					childviewfun(3);
				}
			});
//		View v1=(View)maintimelineview.findViewById(R.id.view1);
		
//		v1.setTag(i);
	
//		if(i==2){
		
//			v1.setBackgroundColor(Color.GREEN);
//			v1.setOnClickListener(new OnClickListener() {
			
//			@Override
//			public void onClick(View v) {
				// TODO Auto-generated method stub
//				actionbottom(("Item  "+i),v,0);
//			}
//		});
//		}
	/*	if(i==5){
			v1.setBackgroundColor(Color.GREEN);
			v1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				childviewfun(3);
			}
		});*/
 		}
		parentview.addView(maintimelineview);
		}
		 mainlinear.addView(parentview);
	}

	 void actionbottom(String message,View v,int flag){
		 ActionItem addItem 		= new ActionItem(ID_ADD, "Interval 2", getResources().getDrawable(R.drawable.ic_add));
			final QuickAction mQuickAction 	= new QuickAction(MainActivity.this);
			mQuickAction.addActionItem(addItem);
			//setup the action item click listener
					mQuickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {
						@Override
						public void onItemClick(QuickAction quickAction, int pos, int actionId) {
							ActionItem actionItem = quickAction.getActionItem(pos);
							
							if (actionId == ID_ADD) {
								Toast.makeText(getApplicationContext(), "Add item selected", Toast.LENGTH_SHORT).show();
							} else {
								Toast.makeText(getApplicationContext(), actionItem.getTitle() + " selected", Toast.LENGTH_SHORT).show();
							}
						}
					});
					
					mQuickAction.setOnDismissListener(new QuickAction.OnDismissListener() {
						@Override
						public void onDismiss() {
							Toast.makeText(getApplicationContext(), "Ups..dismissed", Toast.LENGTH_SHORT).show();
						}
					});
		 
					if(flag==0){
						mQuickAction.show(v);
					}else{
					mQuickAction.show(v);
					mQuickAction.setAnimStyle(QuickAction.ANIM_GROW_FROM_CENTER);
					}
	 }

	 
	 void childviewfun(int childs){
		 final LinearLayout childview=new LinearLayout(MainActivity.this);
		 LayoutParams childviewparams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		 childview.setLayoutParams(childviewparams);
		 for(j=0;j<childs;j++){
				LayoutInflater vi2 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				final View vv= vi2.inflate(R.layout.row2, null);
			    final ImageView imagline1=(ImageView)vv.findViewById(R.id.imageline);
			    imagline1.setVisibility(View.INVISIBLE);
			    imagline1.setTag(j);
			    final TextView textup=(TextView)vv.findViewById(R.id.edit);
			    textup.setVisibility(View.INVISIBLE);
			    textup.setTag(j);
			    final ImageView imagline2=(ImageView)vv.findViewById(R.id.imageline2);
			    imagline2.setVisibility(View.INVISIBLE);
			    imagline2.setTag(j);
			    final TextView textdown=(TextView)vv.findViewById(R.id.edit2);
			    textdown.setVisibility(View.INVISIBLE);
			    textdown.setTag(j);
			    LinearLayout blocklinear=(LinearLayout)vv.findViewById(R.id.backuplinear);
			    
			    blocklinear.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
//						actionbottom(("Sub Item  "+j),v,1);
						imagline1.setVisibility(View.VISIBLE);
						textup.setVisibility(View.VISIBLE);
						imagline2.setVisibility(View.VISIBLE);
						textdown.setVisibility(View.VISIBLE);
					}
				});
				TextView textcross=(TextView)vv.findViewById(R.id.textcross);
				
				if (j<childs-1) {
					textcross.setVisibility(View.GONE);
				}
				
				textcross.setOnClickListener(new OnClickListener() {
				
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						childview.setVisibility(View.GONE);
						 parentview.setVisibility(View.VISIBLE);
					}
				});
				
//				if(j==3){
					
//						vv.setBackgroundColor(Color.GREEN);
					 /*   vv.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								actionbottom(("Sub Item  "+j),v,1);
							}
						});*/
//						}
				
				
//				View v10=(View)vv.findViewById(R.id.view10);
//				if(j==3){
					
				/*	v10.setBackgroundColor(Color.GREEN);
				    v10.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							actionbottom(("Sub Item  "+j),v,1);
						}
					});
//					}
//				TextView textcross=(TextView)vv.findViewById(R.id.textcross);
				textcross.setOnClickListener(new OnClickListener() {
				
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						childview.setVisibility(View.GONE);
						 parentview.setVisibility(View.VISIBLE);
					}
				});
				if(j<childs-1){
					textcross.setVisibility(View.GONE);
				}
				childview.addView(vv);*/
				childview.addView(vv);
			}
		 mainlinear.addView(childview);
		 parentview.setVisibility(View.GONE);
	 }
	 
}
