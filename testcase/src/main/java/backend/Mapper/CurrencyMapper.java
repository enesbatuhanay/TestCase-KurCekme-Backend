package backend.Mapper;

import backend.Contract.CurrencyModel;
import backend.Entity.CurrencyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CurrencyMapper {
    CurrencyEntity toCurrencyEntity(CurrencyModel model);

    CurrencyModel toCurrencyModel(CurrencyEntity entity);
}