package service;

import java.util.List;
import dao.CarroDAO;
import model.Carro;
import spark.Request;
import spark.Response;

public class CarroService {

    private CarroDAO carroDAO = new CarroDAO();

    public Object insert(Request request, Response response) {
        String modelo = request.queryParams("modelo");
        String placa = request.queryParams("placa");
        int ano = Integer.parseInt(request.queryParams("ano"));
        String cor = request.queryParams("cor");

        int marcaId = Integer.parseInt(request.queryParams("marca_id")); // Supondo que você tenha um campo no formulário para selecionar a marca.
        int proprietarioId = Integer.parseInt(request.queryParams("proprietario_id")); // Supondo que você tenha um campo no formulário para selecionar o proprietário.

        Carro carro = new Carro(-1, modelo, placa, ano, cor, marcaId, proprietarioId);

        if (carroDAO.insert(carro)) {
            response.status(201); // 201 Created
            return "Carro (" + modelo + ") inserido!";
        } else {
            response.status(404); // 404 Not Found
            return "Carro (" + modelo + ") não inserido!";
        }
    }

    public Object get(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Carro carro = carroDAO.get(id);

        if (carro != null) {
            response.status(200); // OK
            return carro;
        } else {
            response.status(404); // 404 Not Found
            return "Carro com ID " + id + " não encontrado.";
        }
    }

    public Object getAll(Request request, Response response) {
        List<Carro> carros = carroDAO.getAll();
        return carros;
    }

    public Object update(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Carro carro = carroDAO.get(id);

        if (carro != null) {
            String modelo = request.queryParams("modelo");
            String placa = request.queryParams("placa");
            int ano = Integer.parseInt(request.queryParams("ano"));
            String cor = request.queryParams("cor");

            int marcaId = Integer.parseInt(request.queryParams("marca_id")); // Supondo que você tenha um campo no formulário para selecionar a marca.
            int proprietarioId = Integer.parseInt(request.queryParams("proprietario_id")); // Supondo que você tenha um campo no formulário para selecionar o proprietário.

            carro.setModelo(modelo);
            carro.setPlaca(placa);
            carro.setAno(ano);
            carro.setCor(cor);
            carro.setMarcaId(marcaId);
            carro.setProprietarioId(proprietarioId);

            carroDAO.update(carro);
            response.status(200); // OK
            return "Carro (ID " + id + ") atualizado!";
        } else {
            response.status(404); // 404 Not Found
            return "Carro (ID " + id + ") não encontrado!";
        }
    }

    public Object delete(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Carro carro = carroDAO.get(id);

        if (carro != null) {
            carroDAO.delete(id);
            response.status(200); // OK
            return "Carro (ID " + id + ") excluído!";
        } else {
            response.status(404); // 404 Not Found
            return "Carro (ID " + id + ") não encontrado!";
        }
    }
}
