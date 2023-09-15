// Importar as bibliotecas necessárias
import { BrowserMultiFormatReader } from '@zxing/library';
import { VideoInputDevice } from '@zxing/library';

// Selecionar o elemento de vídeo onde o QR code será exibido
const videoInput = document.getElementById('video-input');

// Criar um leitor de QR code
    const codeReader = new BrowserMultiFormatReader();E 
const selectedDeviceId = undefined; // Deixe como "undefined" para usar a câmera padrão
const videoInputDevices = await VideoInputDevice.getDevices();
const selectedDevice = videoInputDevices.find(device => selectedDeviceId ? device.deviceId === selectedDeviceId : true);
await codeReader.decodeFromVideoDevice(selectedDevice.deviceId, videoInput);

// Adicionar um listener para capturar o resultado da leitura do QR code
codeReader.addListener(result => {
  console.log('QR code lido:', result.text);
  // Aqui você pode adicionar o código para exibir o resultado do QR code no seu aplicativo
});

// Lidar com erros ao capturar o vídeo ou ao ler o QR code
codeReader.errors.addListener(error => {
  console.error('Ocorreu um erro:', error);
});