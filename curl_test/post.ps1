


 # Leer el contenido de los archivos JSON (Datos de entrada y resultado esperado)
    $entityData = Get-Content -Path $entityDataFilePath -Raw
    $expectedData = Get-Content -Path $expectedDataFilePath -Raw



$createResponse = Invoke-RestMethod -Uri "$entityApiUrl" -Method Post -ContentType "application/json" -Body $entityData
    if ($createResponse -eq $expectedData) {
        Write-Host "$entityName CREATE: Success"
    } else {
        Write-Host "$entityName CREATE: Failed"
        Write-Host "Expected: $expectedData"
        Write-Host "Received: $createResponse"
    }
