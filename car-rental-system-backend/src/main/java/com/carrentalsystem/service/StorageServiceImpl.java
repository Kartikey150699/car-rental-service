package com.carrentalsystem.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class StorageServiceImpl implements StorageService {

	// バリアント画像の保存先パス（application.properties から取得）
	@Value("${com.carrentalsystem.image.variant.folder.path}")
	private String VARIANT_IMAGE_BASEPATH;

	// 免許証画像の保存先パス（application.properties から取得）
	@Value("${com.carrentalsystem.image.license.folder.path}")
	private String LICENSE_IMAGE_BASEPATH;

	@Override
	public List<String> loadAllVariantImage() {
		// バリアント画像フォルダ内の全ファイル名を取得
		File dirPath = new File(VARIANT_IMAGE_BASEPATH);
		return Arrays.asList(dirPath.list());
	}

	@Override
	public String storeVariantImage(MultipartFile file) {
		// バリアント画像を保存
		System.out.println(file.getOriginalFilename());
		String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println(ext);
		// UUIDで一意のファイル名を生成
		String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ext;
		File filePath = new File(VARIANT_IMAGE_BASEPATH, fileName);
		try (FileOutputStream out = new FileOutputStream(filePath)) {
			FileCopyUtils.copy(file.getInputStream(), out);
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Resource loadVariantImage(String fileName) {
		// バリアント画像を読み込み
		File filePath = new File(VARIANT_IMAGE_BASEPATH, fileName);
		if (filePath.exists())
			return new FileSystemResource(filePath);
		return null;
	}

	@Override
	public void deleteVariantImage(String fileName) {
		// バリアント画像を削除
		File filePath = new File(VARIANT_IMAGE_BASEPATH, fileName);
		if (filePath.exists())
			filePath.delete();
	}

	@Override
	public List<String> loadAllLicenseImage() {
		// 免許証画像フォルダ内の全ファイル名を取得
		File dirPath = new File(LICENSE_IMAGE_BASEPATH);
		return Arrays.asList(dirPath.list());
	}

	@Override
	public String storeLicenseImage(MultipartFile file) {
		// 免許証画像を保存
		System.out.println(file.getOriginalFilename());
		String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println(ext);
		// UUIDで一意のファイル名を生成
		String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ext;
		File filePath = new File(LICENSE_IMAGE_BASEPATH, fileName);
		try (FileOutputStream out = new FileOutputStream(filePath)) {
			FileCopyUtils.copy(file.getInputStream(), out);
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Resource loadLicenseImage(String fileName) {
		// 免許証画像を読み込み
		File filePath = new File(LICENSE_IMAGE_BASEPATH, fileName);
		if (filePath.exists())
			return new FileSystemResource(filePath);
		return null;
	}

	@Override
	public void deleteLicenseImage(String fileName) {
		// 免許証画像を削除
		File filePath = new File(LICENSE_IMAGE_BASEPATH, fileName);
		if (filePath.exists())
			filePath.delete();
	}

}
