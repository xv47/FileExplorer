package com.example.fileexplorer;
  
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.widget.EditText;
import android.widget.TextView;


public class FileexplorerActivity extends Activity {
 
	private static final int REQUEST_PATH = 1;
 
	private String curFileName = "";
	
	private EditText edittext;
	private TextView bTag;
	
	private static int tag = 0;
	

     
    /**********  File Path *************/
    final String uploadFilePath = Environment.getExternalStorageDirectory() + "/Tossup/";
    
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
       // setContentView(R.layout.activity_fileexplorer); 
        getfile();
        
       
    }
	
    public void getfile(){ 
    	Intent intent1 = new Intent(this, FileChooser.class);
        startActivityForResult(intent1,REQUEST_PATH);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        // See which child activity is calling us back.
    	if (requestCode == REQUEST_PATH){
    		if (resultCode == RESULT_OK) { 
    			curFileName = data.getStringExtra("GetFileName"); 
    			//edittext.setText(curFileName);    			
    			//tag = buildTag(curFileName);
    			//bTag.setText(Integer.toString(tag));
    			Intent returnIntent = new Intent();
    			returnIntent.putExtra("filename", curFileName);
    			setResult(RESULT_OK,returnIntent);
    			finish();
    			
    			
    		}
    	 }
    }
}
