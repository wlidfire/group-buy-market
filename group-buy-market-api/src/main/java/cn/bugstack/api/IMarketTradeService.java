package cn.bugstack.api;

import cn.bugstack.api.dto.SettlementMarketPayOrderRequestDTO;
import cn.bugstack.api.dto.SettlementMarketPayOrderResponseDTO;
import cn.bugstack.api.response.Response;
import cn.bugstack.api.dto.LockMarketPayOrderRequestDTO;
import cn.bugstack.api.dto.LockMarketPayOrderResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface IMarketTradeService {

    Response<LockMarketPayOrderResponseDTO> lockMarketPayOrder(LockMarketPayOrderRequestDTO lockMarketPayOrderRequestDTO);

    Response<SettlementMarketPayOrderResponseDTO> settlementMarketPayOrder(SettlementMarketPayOrderRequestDTO requestDTO);
}
