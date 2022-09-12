export interface LocalStorageMigratorPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
