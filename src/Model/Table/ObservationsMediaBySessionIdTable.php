<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * ObservationsMediaBySessionId Model
 *
 * @method \App\Model\Entity\ObservationsMediaBySessionId get($primaryKey, $options = [])
 * @method \App\Model\Entity\ObservationsMediaBySessionId newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\ObservationsMediaBySessionId[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\ObservationsMediaBySessionId|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\ObservationsMediaBySessionId patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\ObservationsMediaBySessionId[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\ObservationsMediaBySessionId findOrCreate($search, callable $callback = null, $options = [])
 */
class ObservationsMediaBySessionIdTable extends Table
{

    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config)
    {
        parent::initialize($config);

        $this->setTable('observations_media_by_session_id');
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator)
    {
        $validator
            ->scalar('Url')
            ->maxLength('Url', 500)
            ->allowEmpty('Url');

        $validator
            ->scalar('Text')
            ->maxLength('Text', 144)
            ->allowEmpty('Text');

        $validator
            ->integer('Sessions_ID')
            ->requirePresence('Sessions_ID', 'create')
            ->notEmpty('Sessions_ID');

        return $validator;
    }
}
