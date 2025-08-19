package com.carrentalsystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.carrentalsystem.entity.Variant;

// バリアント情報のレスポンス DTO（共通レスポンスを継承）
public class VariantResponse extends CommonApiResponse {

	private List<Variant> variants = new ArrayList<>(); // バリアント一覧

	// --- Getter & Setter ---
	public List<Variant> getVariants() {
		return variants;
	}

	public void setVariants(List<Variant> variants) {
		this.variants = variants;
	}

}
