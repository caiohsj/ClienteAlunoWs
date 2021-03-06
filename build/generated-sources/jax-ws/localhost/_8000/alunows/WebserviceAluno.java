
package localhost._8000.alunows;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebserviceAluno", targetNamespace = "http://localhost:8000/alunows")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebserviceAluno {


    /**
     * 
     * @param aluno
     */
    @WebMethod
    @RequestWrapper(localName = "inserir", targetNamespace = "http://localhost:8000/alunows", className = "localhost._8000.alunows.Inserir")
    @ResponseWrapper(localName = "inserirResponse", targetNamespace = "http://localhost:8000/alunows", className = "localhost._8000.alunows.InserirResponse")
    @Action(input = "http://localhost:8000/alunows/WebserviceAluno/inserirRequest", output = "http://localhost:8000/alunows/WebserviceAluno/inserirResponse")
    public void inserir(
        @WebParam(name = "aluno", targetNamespace = "")
        Aluno aluno);

    /**
     * 
     * @param id
     */
    @WebMethod
    @RequestWrapper(localName = "remover", targetNamespace = "http://localhost:8000/alunows", className = "localhost._8000.alunows.Remover")
    @ResponseWrapper(localName = "removerResponse", targetNamespace = "http://localhost:8000/alunows", className = "localhost._8000.alunows.RemoverResponse")
    @Action(input = "http://localhost:8000/alunows/WebserviceAluno/removerRequest", output = "http://localhost:8000/alunows/WebserviceAluno/removerResponse")
    public void remover(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @return
     *     returns java.util.List<localhost._8000.alunows.Aluno>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listar", targetNamespace = "http://localhost:8000/alunows", className = "localhost._8000.alunows.Listar")
    @ResponseWrapper(localName = "listarResponse", targetNamespace = "http://localhost:8000/alunows", className = "localhost._8000.alunows.ListarResponse")
    @Action(input = "http://localhost:8000/alunows/WebserviceAluno/listarRequest", output = "http://localhost:8000/alunows/WebserviceAluno/listarResponse")
    public List<Aluno> listar();

    /**
     * 
     * @param aluno
     */
    @WebMethod
    @RequestWrapper(localName = "alterar", targetNamespace = "http://localhost:8000/alunows", className = "localhost._8000.alunows.Alterar")
    @ResponseWrapper(localName = "alterarResponse", targetNamespace = "http://localhost:8000/alunows", className = "localhost._8000.alunows.AlterarResponse")
    @Action(input = "http://localhost:8000/alunows/WebserviceAluno/alterarRequest", output = "http://localhost:8000/alunows/WebserviceAluno/alterarResponse")
    public void alterar(
        @WebParam(name = "aluno", targetNamespace = "")
        Aluno aluno);

}
