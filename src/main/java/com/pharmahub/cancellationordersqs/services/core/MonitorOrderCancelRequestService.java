package com.pharmahub.cancellationordersqs.services.core;

public class MonitorOrderCancelRequestService {

    /*
    private final EstadoPedidoService estadoPedidoService;
    private final IP6ConsultaService ip6ConsultaService;
    private final SAPAnuladorService sapAnuladorService;
    private final IRTrackAnuladorService irTrackAnuladorService;
    private final PMMAnuladorService pmmAnuladorService;
    private final OTMAnuladorService otmAnuladorService;
    private final PedidoRepositoryAdapter pedidoRepository;


    public AnularPedidoResponse anularPedido(String pedidoSap) {
        EstadoPedido estado = estadoPedidoService.obtenerEstadoPedido(pedidoSap);

        switch (estado) {
            case PENDIENTE_PROGRAMACION:
                return procesarAnulacion(pedidoSap, false, false);
            case EN_PLANIFICACION:
                return procesarAnulacion(pedidoSap, true, false);
            case CON_PLANIFICACION:
                return procesarConPlanificacion(pedidoSap);
            case CON_ASIGNACION_WMS:
            case EN_CT:
            case FACTURADO:
            default:
                actualizarEstado(pedidoSap, EstadoPedido.DENEGADO);
                return AnularPedidoResponse.builder()
                        .exito(false)
                        .estadoFinal("DENEGADO")
                        .mensaje("No se puede anular el pedido en estado: " + estado)
                        .build();
        }
    }

    private AnularPedidoResponse procesarAnulacion(String pedidoSap, boolean incluirOTM, boolean vieneDeIP6) {
        List<ResultadoOperacion> resultados = new ArrayList<>();

        if (incluirOTM) {
            resultados.add(otmAnuladorService.anular(pedidoSap));
        }

        resultados.add(pmmAnuladorService.anular(pedidoSap));
        resultados.add(irTrackAnuladorService.anular(pedidoSap));
        resultados.add(sapAnuladorService.anular(pedidoSap));

        boolean todosExitosos = resultados.stream().allMatch(ResultadoOperacion::isExito);

        if (todosExitosos) {
            actualizarEstado(pedidoSap, EstadoPedido.ANULADO);
            return AnularPedidoResponse.builder()
                    .exito(true)
                    .estadoFinal("ANULADO")
                    .mensaje("Pedido anulado exitosamente.")
                    .build();
        } else {
            String errores = resultados.stream()
                    .filter(r -> !r.isExito())
                    .map(ResultadoOperacion::getMensaje)
                    .collect(Collectors.joining("; "));
            return AnularPedidoResponse.builder()
                    .exito(false)
                    .estadoFinal("FALLO_PARICIAL")
                    .mensaje("Fallaron algunos procesos: " + errores)
                    .build();
        }
    }

    private AnularPedidoResponse procesarConPlanificacion(String pedidoSap) {
        var ip6 = ip6ConsultaService.consultarEstado(pedidoSap);
        if (ip6.tieneParticion()) {
            if (ip6.estaAnulado()) {
                actualizarEstado(pedidoSap, EstadoPedido.ANULACION_PARCIAL);
                return AnularPedidoResponse.builder()
                        .exito(true)
                        .estadoFinal("ANULACION_PARCIAL")
                        .mensaje("Anulación parcial registrada desde IP6 con partición.")
                        .build();
            } else {
                actualizarEstado(pedidoSap, EstadoPedido.DENEGADO);
                return AnularPedidoResponse.builder()
                        .exito(false)
                        .estadoFinal("DENEGADO")
                        .mensaje("No se pudo anular en IP6 con partición.")
                        .build();
            }
        } else if (ip6.estaAnulado()) {
            return procesarAnulacion(pedidoSap, true, true);
        } else {
            actualizarEstado(pedidoSap, EstadoPedido.DENEGADO);
            return AnularPedidoResponse.builder()
                    .exito(false)
                    .estadoFinal("DENEGADO")
                    .mensaje("No se pudo anular en IP6.")
                    .build();
        }
    }

    private void actualizarEstado(String pedidoSap, EstadoPedido nuevoEstado) {
        pedidoRepository.actualizarEstadoPedido(pedidoSap, nuevoEstado);
    }
    */


}
