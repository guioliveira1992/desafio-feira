package com.gms.challengerFeira.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogsService {
	
	@Value("${path.logs}")
	private String pathFile;
	
	public synchronized void gravarLogs(String log) {
		Thread gravarArquivo = new Thread() {
			@Override
			public void run() {
				try {
					FileWriter fw = new FileWriter( new File(pathFile), true );
					BufferedWriter bw = new BufferedWriter( fw );
					bw.write(log);
					bw.newLine();
					bw.close();
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		
		gravarArquivo.start();
	}

}
