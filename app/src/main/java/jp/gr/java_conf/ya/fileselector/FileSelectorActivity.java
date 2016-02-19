package jp.gr.java_conf.ya.fileselector; // Copyright (c) 2012-2016 YA <ya.androidapp@gmail.com> All rights reserved.

import java.io.File;

import jp.gr.java_conf.ya.fileselector.SelectFileDialog.onSelectFileDialogListener;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class FileSelectorActivity extends Activity implements onSelectFileDialogListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		SelectFile();
	}

	protected SelectFileDialog _dlgSelectFile;

	private void SelectFile() {
		_dlgSelectFile = new SelectFileDialog(this);
		_dlgSelectFile.Show(getString(R.string.path));
	}

	public void onFileSelected_by_SelectFileDialog(File file) {
		if (file != null) {
			Intent intent = getIntent();
			intent.setData(Uri.parse("file://" + file.getPath()));
			setResult(Activity.RESULT_OK, intent);
		}
		_dlgSelectFile = null;
		finish();
	}

	@Override
	public void onPause() {
		if (_dlgSelectFile != null) {
			_dlgSelectFile.onPause();
		}
		super.onPause();
	}
}
