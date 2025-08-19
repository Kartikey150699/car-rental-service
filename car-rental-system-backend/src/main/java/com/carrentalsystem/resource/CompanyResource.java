package com.carrentalsystem.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.carrentalsystem.dto.CommonApiResponse;
import com.carrentalsystem.dto.CompanyResponse;
import com.carrentalsystem.entity.Company;
import com.carrentalsystem.exception.CompanySaveFailedException;
import com.carrentalsystem.service.CompanyService;

@Component
public class CompanyResource {

	// ロガーを使用してログ出力を行う
	private final Logger LOG = LoggerFactory.getLogger(CompanyResource.class);

	@Autowired
	private CompanyService companyService;

	// 会社を追加する処理
	public ResponseEntity<CommonApiResponse> addCompany(Company company) {

		LOG.info("Request received for adding company");

		CommonApiResponse response = new CommonApiResponse();

		// 入力チェック（会社オブジェクトや名前がnullの場合は不正リクエスト）
		if (company == null || company.getName() == null) {
			response.setResponseMessage("bad request - invalid request");
			response.setSuccess(false);

			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.BAD_REQUEST);
		}

		// サービスを呼び出して会社を追加
		Company addedCompany = this.companyService.addCompany(company);

		// 保存に失敗した場合は例外をスロー
		if (addedCompany == null) {
			throw new CompanySaveFailedException("Failed to save Company");
		}

		// 成功レスポンスを返却
		response.setResponseMessage("Company Added Successful!!!");
		response.setSuccess(true);

		return new ResponseEntity<CommonApiResponse>(response, HttpStatus.OK);
	}

	// 全ての会社を取得する処理
	public ResponseEntity<CompanyResponse> fetchAllCompany() {

		LOG.info("Request received for fetching all company");

		CompanyResponse response = new CompanyResponse();

		// DBから全会社を取得
		List<Company> companies = this.companyService.getAllCompany();

		// データが存在しない場合
		if (CollectionUtils.isEmpty(companies)) {
			response.setResponseMessage("No Companies Found!!!");
			response.setSuccess(false);

			return new ResponseEntity<CompanyResponse>(response, HttpStatus.OK);
		}

		// 成功レスポンスとして会社リストを返却
		response.setCompanies(companies);
		response.setResponseMessage("Companies Fetched Successful!!!");
		response.setSuccess(true);

		return new ResponseEntity<CompanyResponse>(response, HttpStatus.OK);

	}
	
	// 会社情報を更新する処理
	public ResponseEntity<CommonApiResponse> updateCompany(Company company) {

		LOG.info("Request received for adding company");

		CommonApiResponse response = new CommonApiResponse();

		// 入力チェック（会社がnull、IDが0、名前がnullの場合は不正リクエスト）
		if (company == null || company.getId() == 0 || company.getName() == null) {
			response.setResponseMessage("bad request - invalid request");
			response.setSuccess(false);

			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.BAD_REQUEST);
		}

		// DBから既存会社を取得
		Company dbCompany = this.companyService.getById(company.getId());
		
		// 存在しない場合
		if(dbCompany == null) {
			response.setResponseMessage("bad request - Company not found");
			response.setSuccess(false);

			return new ResponseEntity<CommonApiResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		// 名前を更新
		dbCompany.setName(company.getName());
		
		// 更新保存
		Company addedCompany = this.companyService.addCompany(dbCompany);

		// 更新に失敗した場合
		if (addedCompany == null) {
			throw new CompanySaveFailedException("Failed to update Company");
		}

		// 成功レスポンス
		response.setResponseMessage("Company Updated Successful!!!");
		response.setSuccess(true);

		return new ResponseEntity<CommonApiResponse>(response, HttpStatus.OK);
	}

}
